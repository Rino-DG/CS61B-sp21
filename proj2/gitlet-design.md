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

#### Fields
1. Field 1
2. Field 2


### Init Command
**What is the best way to structure the .gitlet file?**
>Separate files for commits, blobs, staging area, cwd (current working directory)
The init command will check if there is a repository already initiated. If not, it will initiate a repository
by creating a hidden directory named ".gitlet" this houses all the staging directory, repository, blobs, and
other necessary features of the gitlet program. 


### Commit Command (implements serializable)

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
Have each branch into separate folders. Master is within its own folder ?
