Project: Campus Course & Records Manager (CCRM) - Humanized Code Variant

Requirements
------------
- Java 17 JDK or later
- Recommended IDE: IntelliJ IDEA / Eclipse (optional)
- Build: javac / java (Maven setup optional)

How to compile & run (Linux / macOS with bash)
1. From repository root:
   javac -d out $(find src -name "*.java")
   java -cp out edu.ccrm.cli.CCRMApplication

2. On Windows (PowerShell):
   mkdir out
   javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName
   java -cp out edu.ccrm.cli.CCRMApplication

Project notes
- Data exported to: ${user.home}/ccrm-data
- Minimal seed data is created by the application at startup
- To change storage path modify AppConfig.get().storageFolder() in AppConfig (simple change)
- No external libraries required
