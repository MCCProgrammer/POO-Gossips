# 🗣️ Gossips — Object-Oriented Programming, Project I

<p>
  <img alt="Java" src="https://img.shields.io/badge/Java-1f2328?style=flat-square&logo=openjdk&logoColor=white">
  <img alt="Course" src="https://img.shields.io/badge/Course-Object--Oriented%20Programming%20(POO)-1f2328?style=flat-square">
  <img alt="Year" src="https://img.shields.io/badge/2022%2F23-1st%20year%2C%202nd%20semester-1f2328?style=flat-square">
  <img alt="Tests" src="https://img.shields.io/badge/course%20tests-17%2F17%20passing-1f2328?style=flat-square">
</p>

First project of *Programação Orientada pelos Objetos* (Object-Oriented Programming), Computer Science degree at **NOVA School of Science and Technology (FCT NOVA)**.

## About

A command-line simulation of **how gossip spreads in a small town**. People walk between landmarks (cafés, parks, the library…), form groups with whoever is there, and share the gossips they know with their group. The system keeps track of who knows what about whom.

There are three kinds of people, each behaving differently:

- **Forgetful** — only remembers the last *n* gossips they heard and shares one at a time.
- **Gossiper** — never forgets and shares up to three gossips at once, cycling through everything they know.
- **Sealed lips** — remembers everything but only ever shares gossips about themselves.

You can ask for the groups at a landmark, the gossips a person knows, everything known about someone, and the hottest (most shared) gossip.

## What I practiced

- **Interfaces and abstract classes** — `Person` with `PersonAbstractClass` and three concrete kinds of person
- **Polymorphism** — each kind of person decides differently what to remember and what to share
- Building my own generic **`Array<E>` collection and iterator** instead of using the Java Collections
- Documenting interfaces and methods with preconditions

## Running it

Requires Java 8 or newer.

```bash
cd src
javac -d ../bin $(find . -name "*.java")
java -cp ../bin Main
```

Example session (type `help` to see every command):

```text
landmark 4 Cafe Central
Cafe Central added.
forgetful 2 Ana
Ana can only remember up to 2 gossips.
gossiper Bruno
Bruno is a gossiper.
go Ana
Cafe Central
Ana is now at Cafe Central.
go Bruno
Cafe Central
Bruno is now at Cafe Central.
join Bruno
Ana
Bruno joined Ana, at the Cafe Central.
start Ana
1
Carla
Carla secretly adopted a third cat
Have you heard about Carla? Carla secretly adopted a third cat
gossip Ana
Ana shared with Bruno, some hot news!
Carla secretly adopted a third cat
exit
Bye!
```

## Project structure

```
src/
├── Main.java               # command-line interface
├── Classes_Interfaces/     # community, landmarks, groups, people and gossips
└── dataStructures/         # generic Array<E> and Iterator<E>
```

## Author

**Miguel Carmo** ([@MCCProgrammer](https://github.com/MCCProgrammer))

---

<sub>The assignment statement and the course's test files are not included in this repository, as they belong to the course's teaching staff. This is a student project shared for portfolio purposes.</sub>
