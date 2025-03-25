#!/bin/bash
# Compile the code
javac -d bin src/*.java
# Create a bin directory if it does not exist
mkdir -p bin
# Run tests
for test in tests/*_input.txt; do
    base=$(basename $test _input.txt)
    echo "Running test: $base"
    # Run the program using the test input
    java -cp bin StudentRecordsSystem < tests/${base}_input.txt > output.txt
    # Compare the output with the expected output
    diff -q output.txt tests/${base}_expected.txt
    if [ $? -eq 0 ]; then
        echo "Test $base passed."
    else
        echo "Test $base failed."
        echo "Differences:"
        diff output.txt tests/${base}_expected.txt
        exit 1
    fi
done
echo "All tests passed."
