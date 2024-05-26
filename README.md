# timeapp
This is a java based application to perform operations related to time.

## Usage

At present, TimeApp application supports the conversion of given time in 24-hour format (HH:MM) to spoken words. The program reads input from the console, validates the input, and outputs the corresponding spoken words for the time.


Supported spoken conversions list:

* British Spoken words

## Features
- Converts time in 24-hour format to British spoken words.
- Special cases for `00:00` -> "midnight" and `12:00` -> "noon"
- Validates input using regex.
- Includes TestNG tests for validation.

### British Spoken words:
| Time | Spoken words |
| --- | --- |
| 1:00 | one o'clock |
| 2:05 | five past two |
| 3:10 | ten past three |
| 4:15 | quarter past four |
| 5:20 | twenty past five |


## Requirements
- Java 1.8 or higher
- Maven 3.6.0 or higher

## Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/areshavora/timeapp.git
    cd time-app
    ```

2. **Build the project:**
    ```sh
    mvn clean package
    ```

3. **Run the application:**
   The JAR file will be created in the `output` directory within the project root. Use the following command to run the application:
    ```sh
    java -jar output/time-world-app.jar
    ```

4. **Test the project:**
   The project includes TestNG tests. To run the tests, use the following command:
    ```sh
    mvn test
    ```

## Project Structure
The project is organized as follows:

```bash
TimeApp
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── timeworld
│   │   │           ├── spokentime
│   │   │           │   └── convertor
│   │   │           │       └── BritishTimeConvertor.java
│   │   │           │   └── SpokenTimeConvertor.java
│   │   │           ├── TimeApp.java
│   ├── test
│   │   ├── java
│   │   │   └── com
│   │   │       └── timeworld
│   │   │           └── TestSpokenTime.java
├── output
│   └── time-world-app-1.0.jar
├── pom.xml
└── README.txt
```

== File Descriptions ==

1. `src/main/java/com/timeworld/TimeApp.java`
    * The main application class that reads input from the console and uses SpokenTimeConvertor to output the spoken time.

3. `src/main/java/com/timeworld/spokentime/SpokenTimeConvertor.java`
    * Validated input and Uses time conversion classes and print the converted time to words to console.

2. `src/main/java/com/timeworld/spokentime/convertor/BritishTimeConvertor.java`
    * Class responsible for converting time to British spoken words format with consideration of handling of edge cases of various hour and minute values.


4. `src/test/java/com/timeworld/TestSpokenTime.java`
    * TestNG test class for testing the time conversion logic. At present verify inputs corresponds to supported British conversion only.

5. `output/time-world-app.jar`
    * The executable JAR file generated after building the project.

6. `pom.xml`
    * The Maven project file that includes project dependencies, build plugins, and other configurations.

7. `README.txt`
    * Explain application structure its usages and how to run or test.


## License

[MIT](https://choosealicense.com/licenses/mit/)