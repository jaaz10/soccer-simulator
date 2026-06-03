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

**Command** — Every match action (scoring a goal, making a sub) is wrapped in a command object. One controller runs them all and keeps a log.
Files: MatchCommand, ScoreGoalCommand, SubstitutePlayerCommand, MatchController

## How all connects

Sprint 3 builds the teams (Builder + Factory + Strategy). Sprint 4 runs the match (State + Command). Main just wires them together.

## run

```
javac src/*.java
java -cp src Main
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

Test: run `Main` and check section **5. OBSERVER PATTERN (Sprint 5)** for `📢` commentary lines.

