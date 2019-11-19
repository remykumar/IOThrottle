# IOThrottle
This program/application is to create IO chaos for resiliency validation/chaos engineering. Detailed documentation will be provided shortly. Running the program (java -jar IOThrottle.jar) - will prompt you for triggering the Read chaos or Write chaos or Both. 
- If you give "Read" option, the program will create Read chaos on the OS running it.  
- If you give "Write" option, the program will create Write chaos on the OS running it. 
- If you give "Both(Read/Write)", the program will create Read & Write chaos on the OS. The impact could be devasting on machines with magnetic drives(HDD) when run for longer duration. 

Suggested to monitor the IO chaos real time. 
