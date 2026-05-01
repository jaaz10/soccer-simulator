**Are you in a Group?**  
No

**If so, who else is in your group?**  
Just me

**What programming language are you selecting? Which version?**  
Java 23

**Do you have your GitHub account set up?**  
Yes

**Do you have a public repository for your Project?**  
Yes

**What is the link to your GitHub repository?**  
https://github.com/jaaz10/soccer-simulator

**If you are in a group, does everyone have access to the github repo?**  
No group

**Do you have a "Hello World" program that compiles and runs?**  
Yes

**Where is the entry point to your project?**  
src/main/Main.java

## Sprint 2

**Project:** Soccer Simulator

**Description:**
A CL soccer game sim that uses random algos and player stats to sim match event and outcomes.

**Libraries:**
- 'java.util.Random' - For randomizing match events
- 'java.util ArrayList' - For managing the players and teams collectons
- Java Standard Library

**Planned Features:**
- Player management with skill levels
- Team comp and management
- Match sim w/ random events
- Outputing match commentary as well

**Design Patterns (will be implemented in future)**
1. Factory - making different types of player
2. Strategy - making different team formations/tactics
3. Observer - making notifications of match events
4. Singleton - match/game manager
5. State - states of the game like kickoff, playing, halftime, fulltime
6. Command - actions players take like passing, shooting and tackling

# To compile it outputs to src/bin
javac -d src/bin src/main/*.java

# Then run
java -cp src/bin main.Main

## Sprint 3: Implemented Design Patterns

#### 1. Factory Pattern
**Reason:** Makes different player types according to position
**Classes:** 'PlayerFactory' & 'Player'
**Advantages** Makes player creation central and its easier to add new postions

#### 2. Stragety Pattern
**Reason:** Lets teams use various tactics dynamically
**Classes:** 'TacticStragety' this is interface, 'AttackingTactic' & 'DefendingTactic'
**Advantages:** Teams can change stragety at runtime and easier to add new tactics

### Final Submission Plans

I plan on demonstrating:
- Full match sim with teams using various strageties
- Multiple types of players can be created via the Factory pattern
- Match commentary showing tactical decisions
- Tracking score and results of the game
- CLI interactivity so user can choose tactics

### Problems Encountered

**Issue 1:** Started having issues with how to integrate stragety bonus into real gameplay
**Solution:** Plan to add bonus calc in future Match class

**Issue 2:** Player class right now is simple but may need subclasses for various positions
**Solution:** May need to extend in next Sprint 

**Issue 3:** Need to connect patterns together in actual match sim
**Solution:** Next Sprint I will create Match/Team classes that use the patterns

### Next Steps
- Make Team class that uses TacticStragety
- Make Match class that sims games
- Implement Observer pattern for match events
- Add State pattern for phases of the match
