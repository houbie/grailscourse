# Grails Course

## Required software / downloads

### Git source code management
- Download [Git](http://git-scm.com/download)
- Run the installer and accept the defaults, except for:
    - select _Run git from windows command prompt_
	- select _checkout as-is, commit unix-style line endings_
- Open a terminal and type `git --version` to make sure the installation was successful

### JDK
- The course requires JDK 7 (check with `java -version` in a terminal).
- The JDK can be downloaded from [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- Set the environment variable `JAVA_HOME` to point to the JDK installation directory.

### Intellij IDEA
- Download [Intellij IDEA 13 beta](http://confluence.jetbrains.com/display/IDEADEV/IDEA+13+EAP) (for windows, download the installer) and run the installer.
- Grails requires the full (ultimate) edition.
- Intellij can be tried for free during 30 days. After the trial period, you need to purchase a license or [apply](http://www.jetbrains.com/idea/buy/choose_edition.jsp?license=CLASSROOM) for a free classroom version.

### Grails
- Download the latest [Grails](http://grails.org/download) distribution and unzip it.
- Set the environment variable `GRAILS_HOME` to point to the grails directory.
- Add `GRAILS_HOM/bin` to your path
- Open a terminal and type `grails --version` to make sure the installation was successful
- Also download the Grails documentation, unzip it and bookmark `guide/single.html` (you will often need it)

### Groovy documentation
- Download and unzip the [Groovy documentation](http://groovy.codehaus.org/Download)
- Bookmark `groovy-jdk/index.html`

## Getting started
NOTE: The build process of every software project should be fully automated. That's why we will use command line tools now and then, even if it could be done from within the IDE.

### Your first Grails project
- Open a terminal window and go to the directory where you want to store all your projects
- Type `grails create-app hello-grails`
- `cd hello-grails`
- `grails run-app` ... this might take a while because all the dependencies need to be downloaded
- When the server started, open _http://localhost:8080/hello-grails_ in your browser
- Stop the server with _Ctrl-C_

### Your first domain class
- Start Intellij
- Import the project in Intellij:
    - _File_ -> _Import Project..._ -> select the _hello-grails_ directory
	- Select _Create project from existing sources_
	- Click _Next_ until you arrive at the SDK selection screen
	- Select the 1.7 SDK, or when it is not available, click the + sign and navigate to your JDK 7 directory
	- Click _Next_ and select the Grails library (the first time you will need to create it)
	- Click _Next_ and finish the wizard
- Open the _Grails View_ in the upper left corner of Intellij
- Create a new domain class:
    - Right-click on _Domain classes_ -> _New_ -> _ Grails domain class_ -> type `hello.person`
    - Add two lines inside the Person class: 
        - `String firstName`
	    - `String lastName`
- Create a new controller
    - Right-click on Controllers_ -> _New_ -> _ Grails Controller_ -> type `hello.person`
    - Delete the line _def index() { }_ 
    - type `st`, wait for the autocomplete and press _Enter_
	- type `sc`, wait for the autocomplete, press the _down key_ and then `Enter`
	- type `tr`, wait for the autocomplete and press _Enter_
	- the complete line should now be _static scaffold = true_
- Try what you just created:
    - Click the green arrow at the top (next to _Grails:hello-grails_)
	- When the server is started, click on the link at the bottom in the _Run_ console. This should open the application in a browser.
	- In the browser, click on the _hello.PersonController_ link and start experimenting
	
## Preparing the course material
- Open a terminal window and go to the directory where you want to store all your projects
- Type `git clone https://github.com/houbie/grailscourse.git`
- `cd grailscourse/groovy-kickstart`
- `gradlew test` (windows) or `./gradlew test` (Max, linux), this should compile the project and run the tests
- `gradlew idea`, this creates the Intellij project files
- Open the _groovy-kickstart_ project in Intellij
    - Configure git in Intellij
        - _File_ -> _Other Settings_ -> _Default Settings..._
		- Type `git` in the search box and select _Version Control_ -> _Git_
		- Enter the path to the git executable and test it
    - Run some groovy commands
    	_ Tools_ -> _Groovy Console..._
	    - Type `println 'hello groovy!'` in the console and press _Enter_
	
Now you are ready for the course!!!