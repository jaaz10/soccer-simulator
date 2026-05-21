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

Sprint 3: Implemented Design Patterns + Refactoring

Sprint 3 was not only about adding patterns — it refactored the project so later sprints could plug in new behavior without rewriting core code.

Refactoring goals (setup for Sprint 4 and Sprint 5)
- Separate concerns: team setup vs match flow vs future match events
- Keep `Main` as a thin demo/test entry point
- Use small, focused classes (SRP) so new patterns drop in cleanly

What was refactored
- **Factory Method** (`PlayerCreator` + position creators): player creation moved out of `Main`; new positions can be added without touching match code
- **Builder** (`TeamBuilder`): builds complete `Team` objects in one place; `Main` only chains calls like `setName`, `addPlayer`, `setTactic`
- **Strategy** (`TacticStrategy`, `AttackingTactic`, `DefensiveTactic`): tactics are swappable on a team without changing team or match logic
- **Singleton** (`WorldCup`): one tournament manager instance, ready for Sprint 5 when multiple matches or a full tournament flow is added
- **Cleaner `Team` / `Player` model**: match simulation can focus on `Match` instead of how rosters are built

Why this matters for Sprint 4
- `Match` became the single context for game flow → State pattern (pre-match, halves, full time) fit naturally
- `Main` already orchestrated setup, not low-level logic → Command pattern (wrap actions, run via `MatchController`) was a small add-on, not a rewrite

Why this matters for Sprint 5 (planned)
- **Observer**: `Match` / commands can notify listeners when goals or state changes happen (commentary, UI, logging)
- **More commands**: pass, shoot, tackle as new `Command` classes; same `MatchController` invoker
- **Singleton + Builder**: `WorldCup` can register teams built with `TeamBuilder` and run a series of matches

1. Factory Method Pattern
Reason: Makes different player types according to position.
Classes: `PlayerCreator` (abstract), `ForwardCreator`, `MidfielderCreator`, `DefenderCreator`, `GoalkeeperCreator`, `Player`
Advantages: Player creation is centralized; easier to add new positions without changing `Main` or `Match`.

2. Strategy Pattern
Reason: Lets teams use various tactics dynamically.
Classes: `TacticStrategy` (interface), `AttackingTactic`, `DefensiveTactic`
Advantages: Teams can change strategy at runtime; easier to add new tactics.

3. Builder Pattern
Reason: Step-by-step team construction without a huge constructor.
Classes: `TeamBuilder`, `Team`
Advantages: Readable team setup in `Main`; hides Factory Method details inside `addPlayer`.

4. Singleton Pattern
Reason: One shared tournament/game manager for the app.
Classes: `WorldCup`
Advantages: Single source of truth for tournament data; ready for multi-match flows in Sprint 5.

Sprint 4: State + Command Patterns

Built on the Sprint 3 refactor — `Match` handles flow, commands handle actions, `Main` stays thin.

5. State Pattern
Reason: Match behavior changes by phase (pre-match, first half, half time, second half, full time).
Classes: `MatchState` (interface), `PreMatchState`, `FirstHalfState`, `HalfTimeState`, `SecondHalfState`, `FullTimeState`, `Match` (context)
Advantages: Each state owns its rules (e.g. when scoring is allowed); easy to add new phases.

6. Command Pattern
Reason: Wrap match actions so `Main` runs them through one invoker instead of calling `Match` methods everywhere.
Classes: `Command` (interface), `StartMatchCommand`, `EndHalfCommand`, `EndMatchCommand`, `ScoreGoalCommand`, `MatchController` (invoker)
Advantages: One class per action (SRP); no static factories; easy to add Sprint 5 player commands the same way.

How Sprint 3 → Sprint 4 fit together
```
Sprint 3: TeamBuilder + Factory Method + Strategy  →  builds teams
          Match (context)                         →  owns match flow
Sprint 4: MatchState                              →  controls what is allowed when
          Command + MatchController             →  triggers actions on Match
```

Test: same compile/run as above via `src/Main.java`

Sprint 5 (planned next)
- Observer — match event notifications (goals, state changes, commentary)
- More commands — player actions (pass, shoot, tackle)
- WorldCup — run multiple matches / simple tournament using existing Builder + Singleton

