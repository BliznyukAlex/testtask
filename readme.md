# CustomerWriter

Test task for Playnance.com

## Getting Started

The project is located at https: https://github.com/BliznyukAlex/testtask

Source code can be download as Zip file or by using Git
https://github.com/BliznyukAlex/testtask.git

# Running the application

1. Run script "imagebuilder.sh" in folder customergetter (use: ./imagebuilder.sh)

2. Run script "imagebuilder.sh" in folder customerwriter (use: ./imagebuilder.sh)

3. Run docker-compose.yml in folder customerwriter(use: docker-compose up -d)

4. After 10-20 sec run "docker ps" and check if customerwriter_appcustomergetter_1 and 
customerwriter_appcustomerwriter_1 are running. If no you can use docker-ui to start them or use scripts:
dockerstarwriter.sh and dockerstartgetter.sh