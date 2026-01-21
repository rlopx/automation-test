#!/usr/bin/env python3

import os
import shutil
import subprocess
import sys

# ---- CONFIG -------------------------------------------------

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, ".."))
FEATURE_DIR = os.path.join(PROJECT_ROOT, "src", "test", "resources")

# ANSI Colors
GREEN = "\033[92m"
YELLOW = "\033[93m"
CYAN = "\033[96m"
RED = "\033[91m"
RESET = "\033[0m"


# ---- UTILS --------------------------------------------------

def print_header(text):
    print(f"\n{CYAN}==== {text} ===={RESET}\n")


def print_error(text):
    print(f"{RED}ERROR: {text}{RESET}")


def pause():
    input(f"\n{YELLOW}Press ENTER to return to the menu...{RESET}")


# ---- HELPER FUNCTIONS --------------------------------------
def find_maven():
    """
    Finds mvn executable in a cross-platform way.
    Returns the correct executable name/path.
    """
    for cmd in ("mvn.cmd", "mvn"):
        path = shutil.which(cmd)
        if path:
            return path
    raise RuntimeError("Maven (mvn) was not found in PATH")


MVN = find_maven()


# ---- FEATURE DISCOVERY -------------------------------------

def find_feature_files():
    features = []
    for root, _, files in os.walk(FEATURE_DIR):
        for file in files:
            if file.endswith(".feature"):
                features.append(os.path.join(root, file))
    return sorted(features)


def parse_selection(selection, max_index):
    selection = selection.strip().lower()
    indexes = set()

    if selection == "all":
        return list(range(max_index))

    for part in selection.split(","):
        part = part.strip()
        if "-" in part:
            start, end = part.split("-")
            indexes.update(range(int(start) - 1, int(end)))
        else:
            indexes.add(int(part) - 1)

    valid = [i for i in indexes if 0 <= i < max_index]
    if not valid:
        raise ValueError("Invalid feature selection.")

    return sorted(valid)


# ---- MAVEN EXECUTION ---------------------------------------

def run_command(command):
    print(f"{YELLOW}Executing:{RESET}")
    print(f"{GREEN}{' '.join(command)}{RESET}\n")

    try:
        subprocess.run(
            command,
            cwd=PROJECT_ROOT,  # ✅ ensures pom.xml is found
            check=True
        )
    except subprocess.CalledProcessError:
        print_error("Maven execution failed.")


# ---- MENU ACTIONS ------------------------------------------

def run_by_features():
    features = find_feature_files()

    if not features:
        print_error("No .feature files found.")
        return

    print_header("Available Features")
    for i, feature in enumerate(features, 1):
        print(f"{i}. {os.path.basename(feature)}")

    try:
        selection = input("\nSelect feature(s) (1,3 | 2-4 | all): ")
        indexes = parse_selection(selection, len(features))
        selected = [features[i] for i in indexes]
    except Exception as e:
        print_error(str(e))
        return

    parallel = input("Enable parallel execution? (y/n): ").lower() == "y"
    threads = input("Thread count [default=4]: ").strip() or "4"

    cmd = [
        MVN, "clean", "test",
        f"-Dcucumber.features={','.join(selected)}"
    ]

    if parallel:
        cmd.extend([
            "-Dparallel=methods",
            f"-DthreadCount={threads}"
        ])

    run_command(cmd)


def run_by_tags():
    print_header("Run by Tags")

    framework = input("Framework (cucumber/testng): ").strip().lower()
    tags = input("Enter tag(s) or group(s): ").strip()

    if not tags:
        print_error("Tags cannot be empty.")
        return

    parallel = input("Enable parallel execution? (y/n): ").lower() == "y"
    threads = input("Thread count [default=4]: ").strip() or "4"

    cmd = ["mvn", "clean", "test"]

    if framework == "cucumber":
        cmd.append(f"-Dcucumber.filter.tags={tags}")
    elif framework == "testng":
        cmd.append(f"-Dgroups={tags}")
    else:
        print_error("Unsupported framework.")
        return

    if parallel:
        cmd.extend([
            "-Dparallel=methods",
            f"-DthreadCount={threads}"
        ])

    run_command(cmd)


def run_all_tests():
    print_header("Run All Tests")

    parallel = input("Enable parallel execution? (y/n): ").lower() == "y"
    threads = input("Thread count [default=4]: ").strip() or "4"

    cmd = ["mvn", "clean", "test"]

    if parallel:
        cmd.extend([
            "-Dparallel=methods",
            f"-DthreadCount={threads}"
        ])

    run_command(cmd)


# ---- MAIN LOOP ---------------------------------------------

def main():
    while True:
        print_header("Maven Test Runner")

        print("1. Run by feature")
        print("2. Run by tag(s) / group(s)")
        print("3. Run all tests")
        print("0. Exit")

        choice = input("\nChoose an option: ").strip()

        if choice == "1":
            run_by_features()
            pause()
        elif choice == "2":
            run_by_tags()
            pause()
        elif choice == "3":
            run_all_tests()
            pause()
        elif choice == "0":
            print(f"\n{GREEN}Goodbye!{RESET}")
            break
        else:
            print_error("Invalid option.")


# ---- ENTRY POINT -------------------------------------------

if __name__ == "__main__":
    main()
