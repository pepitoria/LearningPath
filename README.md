# LearningPath

POC app using [pokeapi](https://pokeapi.co/docs/v2) to practice android/kotlin

## Table of contents

* [Path Structure](#path-structure)
* [Gitflow](#gitflow)

## Path Structure

The development of this simple app will be done in discrete "lessons". Each lesson should cover one topic to focus on. The process is learning by doing, so each lesson will require to perform a task, with some hints to be followed. Also, each lesson will contain a list of terms that the student may
need to look up to finish the lesson.

The lesson statements can be found in this repository's wiki.

## Gitflow

We'll start with a master branch from which we'll create a develop branch. Each lesson will be a new branch off develop. Once a lesson has been successfully finished, it will be merged onto develop. After testing everything -both the new lesson code and the code from previous lessons - works, it
will be merged into master and tagged with "lessonXX", XX being the lesson number.