# Text Toolkit

Text Toolkit is a small reusable Java 17 library created for CST8411 Assignment 1.
It provides common text-processing and text-statistics functions and includes a runnable demonstration class.

## Features

- Blank text detection
- Whitespace normalization
- String reversal
- Palindrome detection
- Title-case conversion
- Safe text truncation
- Substring occurrence counting
- Word, letter, and digit counts
- Case-insensitive word-frequency maps

## Build

```bash
mvn clean test package
```

The JAR is created at:

```text
target/text-toolkit-1.0.0.jar
```

Run the demonstration:

```bash
java -jar target/text-toolkit-1.0.0.jar
```

## Maven coordinates

```text
Group ID:    ca.algonquin.cst8411
Artifact ID: text-toolkit
Version:     1.0.0
```

## GitHub Packages

Before publishing, edit `github.owner` in `pom.xml` and replace `YOUR_GITHUB_USERNAME` with your GitHub username.
Then configure a GitHub token in Maven `settings.xml` under the server id `github` and run:

```bash
mvn deploy
```
