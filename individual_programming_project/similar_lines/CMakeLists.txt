cmake_minimum_required(VERSION 3.0)
project(similar_lines)

if (NOT CMAKE_BUILD_TYPE)
    message(STATUS "No build type selected, default to Release")
    set(CMAKE_BUILD_TYPE "Release")
endif ()

# Nie chcemy oglądać komunikatów o procentowym postępie kompilacji.
set_property(GLOBAL PROPERTY RULE_MESSAGES OFF)

# Chcemy zobaczyć polecenia wywołane przez make.
set(CMAKE_VERBOSE_MAKEFILE ON)

# Ustawiamy wspólne opcje kompilowania dla wszystkich wariantów projektu.
set(CMAKE_C_FLAGS "-std=c11 -Wall -Wextra")
# Domyślne opcje dla wariantów Release i Debug są sensowne.
# Jeśli to konieczne, ustawiamy tu inne.
# set(CMAKE_C_FLAGS_RELEASE "-O3 -DNDEBUG")
# set(CMAKE_C_FLAGS_DEBUG "-g")

# Wskazujemy pliki źródłowe.
set(SOURCE_FILES
    src/check_type_functions.c
    src/check_type_functions.h
    src/make_and_print_output.c
    src/make_and_print_output.h
    src/read_and_parse_input.c
    src/read_and_parse_input.h
    src/sort_lines.c
    src/sort_lines.h
    src/structs.h
    src/similar_lines.c)

# Wskazujemy plik wykonywalny.
add_executable(similar_lines ${SOURCE_FILES})

