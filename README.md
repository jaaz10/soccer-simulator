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

---

# Sprint 3: Design Patterns + Cleanup

Sprint 3 added design patterns and cleaned up the code so future sprints don't require rewriting everything.

## What got cleaned up

- Moved player creation out of Main into its own classes
- Made team building a simple chain of method calls
- Kept Main short — it just sets things up and runs the sim

## Patterns added

**Factory Method** — Creates players based on position (Forward, Defender, etc.) without cluttering Main.
Files: PlayerCreator, ForwardCreator, MidfielderCreator, DefenderCreator, GoalkeeperCreator, Player

**Strategy** — Lets a team swap tactics (Attacking or Defensive) without changing any other code.
Files: TacticStrategy, AttackingTactic, DefensiveTactic

**Builder** — Builds a team step by step instead of one giant constructor call.
Files: TeamBuilder, Team

**Singleton** — One WorldCup object manages the whole tournament.
Files: WorldCup

## Why cleanup is good

It made Sprint 4 easy to add. Match was already its own class, so dropping in states and commands didn't break anything.

---

# Sprint 4: State + Command Patterns

Built on top of Sprint 3. Match now moves through phases, and actions go through a controller.

**State** — The match goes through phases: pre-match → first half → half time → second half → full time. Each phase is its own class with its own rules.
Files: MatchState, PreMatchState, FirstHalfState, HalfTimeState, SecondHalfState, FullTimeState, Match

**Command** — Every match action (scoring a goal, ending a half, etc.) is wrapped in a command object. The controller runs them and keeps a history log.
Files: Command, StartMatchCommand, EndHalfCommand, EndMatchCommand, ScoreGoalCommand, MatchController

## How all connects

Sprint 3 builds the teams (Builder + Factory + Strategy). Sprint 4 runs the match (State + Command). Main just wires them together.

## run

```
javac -d src/bin src/*.java
java -cp src/bin Main
```

---

# Sprint 5: Observer Pattern

`Match` is the subject: when goals are scored or the state changes, it notifies registered listeners. `CommentaryObserver` prints live commentary (`📢` lines) so match events are not hard-coded only in `Match` / `Main`.

**Observer** — Decouple match events from how they are displayed (commentary, logging, UI later).
Files: `MatchObserver` (interface), `CommentaryObserver`, `Match` (`addObserver`, `notifyObservers`)

## How it fits

```
Match (subject)  →  goal / state change  →  notifyObservers()
CommentaryObserver  →  update(event)
```

Test: run `Main` and check section for `📢` commentary lines.

---

# Final Submission

## All 7 Design Patterns

Here is every pattern in the project and what files go with it. I ended up with 7.

| # | Pattern | What it does in this project | Files |
|---|---------|------------------------------|-------|
| 1 | Singleton | Only one WorldCup object ever exists | WorldCup |
| 2 | Builder | Builds a Team step by step (name, players, tactic) | TeamBuilder, Team |
| 3 | Factory Method | Creates the right kind of Player based on position | PlayerCreator, ForwardCreator, MidfielderCreator, DefenderCreator, GoalkeeperCreator, Player |
| 4 | Strategy | Lets a Team swap between Attacking and Defensive tactics | TacticStrategy, AttackingTactic, DefensiveTactic |
| 5 | State | Controls what the Match can do depending on the current phase | MatchState, PreMatchState, FirstHalfState, HalfTimeState, SecondHalfState, FullTimeState, Match |
| 6 | Command | Wraps match actions (score, start, end) into objects so a controller can run them | Command, StartMatchCommand, EndHalfCommand, EndMatchCommand, ScoreGoalCommand, MatchController |
| 7 | Observer | Match tells listeners when something happens, CommentaryObserver prints it | MatchObserver, CommentaryObserver, Match |

## How to compile and run

```
javac -d src/bin src/*.java
java -cp src/bin Main
```

## Bugs

- WorldCup singleton is not thread-safe. It uses lazy initialization without `synchronized`, so if two threads called `getInstance()` at the same time you could get two objects. Does not matter here since the program is single-threaded but worth noting.
- The MatchController is shared between both demo matches, so its command history shows commands from both matches mixed together. Ideally each match would have its own controller.

## Stuff that is not finished

- **No random simulation.** Goals and events are hard-coded in Main. The original plan was to use `java.util.Random` and player skill levels to decide what happens, but I focused on getting the design patterns right instead.
- **No user input.** You cannot pick teams or trigger events yourself. It just runs the demo automatically.
- **Skill levels don't do anything.** Players have a skill number but it never affects the match outcome since there is no random engine.
- **No real tournament.** WorldCup stores teams but does not run a bracket or group stage.
- **No saving.** You cannot save or load a match.

## UML

The UML diagram is in `UML.drawio.png` at the root.
