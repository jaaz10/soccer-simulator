Are you in a Group?
No

If so, who else is in your group?
Just me

What programming language are you selecting? Which version?
Java 23

Do you have your GitHub account set up?
Yes

Do you have a public repository for your Project?
Yes

What is the link to your GitHub repository?
https://github.com/jaaz10/soccer-simulator

If you are in a group, does everyone have access to the github repo?
No group

Do you have a "Hello World" program that compiles and runs?
Yes

Where is the entry point to your project?
src/Main.java

Sprint 2
Project: Soccer Simulator

Description: A CL soccer game sim that uses random algos and player stats to sim match event and outcomes.

Libraries:

'java.util.Random' - For randomizing match events
'java.util ArrayList' - For managing the players and teams collectons
Java Standard Library
Planned Features:

Player management with skill levels
Team comp and management
Match sim w/ random events
Outputing match commentary as well
Design Patterns (will be implemented in future)

Factory - making different types of player
Strategy - making different team formations/tactics
Observer - making notifications of match events
Singleton - match/game manager
State - states of the game like kickoff, playing, halftime, fulltime
Command - actions players take like passing, shooting and tackling
To compile (outputs to src/bin)
javac -d src/bin src/*.java

Then run
java -cp src/bin Main

Sprint 3: Implemented Design Patterns
1. Factory Pattern
Reason: Makes different player types according to position Classes: 'PlayerFactory' & 'Player' Advantages Makes player creation central and its easier to add new postions

2. Stragety Pattern
Reason: Lets teams use various tactics dynamically Classes: 'TacticStragety' this is interface, 'AttackingTactic' & 'DefendingTactic' Advantages: Teams can change stragety at runtime and easier to add new tactics



