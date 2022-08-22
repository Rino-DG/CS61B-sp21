# Gitlet Design Document

**Name**: Rino De Guzman

---

## Classes and Data Structures

---

### Main
*Reminder*
- Do not do everything in the main class
- Use main to call helper methods
- Use the lab 6 as inspiration for the structure of this project
Cases For Each Command
*Staging Area*
>See how the staging area would be used, which commands will interact with the staging area, which commands won't.
After that, 
1. Init
2. Add
3. Commit
4. rm
5. log
6. global-log
7. find
8. status
9. checkout
10. branch
11. rm-branch


TODO: 
- Implement the helper methods that help guarantee persistence first.
   - A lot of loading & saving you’ll be doing are similar to operations you did in lab 12 (Capers)




### Init Command
**What is the best way to structure the .gitlet file?**
>Separate files for commits, blobs, staging area, cwd (current working directory)
The init command will check if there is a repository already initiated. If not, it will initiate a repository
by creating a hidden directory named ".gitlet" this houses all the staging directory, repository, blobs, and
other necessary features of the gitlet program. 
> 2 directories: objects and refs. The "objects" directory contains all the objects created and 
> used for the program to run. The "refs" directory contains all the heads saved for each branch

#### Fields
1. ...mkdir() ~ Creates all the directories needed such as .gitlet, objects, and refs
2. (*your chosen commit*).SaveCommit() ~ Saves a commit by writing the object to a file named as the commit's SHA-1 hash
3. setBranchTo(*Branch Name*) ~ In this case, it sets the branch to a default branch named "master"
4. setHeadTo(*Commit Hash*) ~ Set's the head to a specific commit given the sha-1 hash as a parameter


### Add 



### Staging Area
- What data structures should be used for the staging area?
- How will it interact with blobs?
- What commands interact with the staging area?
- Add, Commit, Checkout, and reset
  - Add
    - Adds a copy of the file as it currently exists to the staging area
    - Staging an already-staged file overwrites the previous entry in the staging area with the new contents.
    - If the current working version of the file is identical to the version in the current commit, do not stage it to be added...
    - and remove it from the staging area if it is already there (as can happen when a file is changed, added, and then changed back to it’s original version).
  - Commit
    - A snapshot of the staging area is saved when there is a commit
    - The staging area is cleared after a commit


### Blobs
- It will store 2 things, the self hash, and the content of the file


### Commit Command (implements serializable)
Commits will be stored in a binary search tree map structure from java.util, the initial commit will start off
as the root of the tree. This allows the access of commits to be o-log(n).
The keys will be the sha-1 hash of each commit and the value will be the object of the commit
itself. Since deletion is not a concern for the commit tree, we will not need to worry about that. Or should we use
a hash map?

#### Fields
1. Commit Message (String)
2. SHA 1 Parent ID (String)
    * Use a hash as the version number, specifically in hexadecimal notation
3. Timestamp (Java time)
4. File object that creates an url of the commit directory


### Failure Helper Method
This would be a helper class/method that would take care of the general failure cases that do not apply
to a particular command


### Blob class (implements serializable)
This would be an attempt to have a separate blob class. It will be able to be instantiated and created as 
a new object

#### Fields
1. SHA-1 Hash as the file name
2. File Content

## Algorithms


## Persistence


## Branch
The branch will contain a reference to a commit represented as a SHA-1 Hash in String format.

### HashObject
Use Utils class provided with the skeleton to create a separate class for hashing objects. This will
prevent redundancy and can hash any object created in the project.


