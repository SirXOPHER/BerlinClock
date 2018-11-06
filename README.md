Berlin Clock
============

![Berlin Clock](https://upload.wikimedia.org/wikipedia/commons/4/4f/Berlin-Uhr-1650-1705.gif)

Goal
====
Create a representation of the Berlin Clock (see description below) for a given time. 

Time input should be in the format ***hh:mm:ss*** where 
- hh represents hours from 0 to 24 (hours between 0 and 9 should have the leading zero at the beginning e.g. 04).
- mm represents minutes from 0 to 59 (minutes between 0 and 9 should have the leading zero at the beginning e.g. 06).
- ss represents seconds from 0 to 59 (seconds between 0 and 9 should have the leading zero at the beginning e.g. 09).

The result of transformations should be printed on the console in the following format:
```
                 * *
               *     *
              *   Y   *
               *     *
                 * *
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   R   ║║   R   ║║   R   ║║   R   ║
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   R   ║║   R   ║║   R   ║║   R   ║
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
 ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗
 ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║Y║
 ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   Y   ║║   Y   ║║   Y   ║║   Y   ║
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
 ```
 Y = Yellow
 R = Red
 O = Off (instead of R or Y)

Description
===========
The Berlin Clock is a strange way to show the time ([see more](https://en.wikipedia.org/wiki/Mengenlehreuhr#Telling_the_time)).

On the top of the clock there is a ***yellow*** lamp that blinks on/off. It blinks to denote even-numbered (when lit) or odd-numbered (when unlit) seconds.
The time is calculated by adding rectangular lamps.

The ***top two rows*** of rectangular lamps are ***red***. These indicate the hours of a day. In ***the top row*** there are 4 red lamps.
Every lamp represents ***5 hours***. In ***the lower row*** of red lamps every lamp represents ***1 hour***.
So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1pm.

***The two rows of lamps at the bottom*** count the minutes. The first of these rows has 11 lamps, the second 4.
In ***the first row*** every lamp represents ***5 minutes***.
In this first row the 3rd, 6th and 9th lamp are ***red*** and indicate the first quarter, half and last quarter of an hour.
The other lamps are ***yellow***. In ***the last row*** with 4 ***yellow*** lamps every lamp represents ***1 minute***.

The lamps are switched on from left to right.

Examples
========

For 10:13:00:
-------------
```
                 * *
               *     *
              *   Y   *
               *     *
                 * *
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   R   ║║   R   ║║   O   ║║   O   ║ = 5 hours   x 2 lamps = 10 hours 
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   O   ║║   O   ║║   O   ║║   O   ║ = 1 hour    x 0 lamps =  0 hours 
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝ ----------------------------------
 ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗
 ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║ = 5 minutes x 2 lamps = 10 minutes
 ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝
 ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
 ║   Y   ║║   Y   ║║   Y   ║║   O   ║ = 1 minute  x 3 lamps =  3 minutes 
 ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
                                      -----------------------------------------------------
                                      10 hours + 0 hours + 10 minutes + 3 minutes = 10:13am
 ```
 Y = Yellow
 R = Red
 O = Off
 
 For 17:37:01:
 -------------
 ```
                  * *
                *     *
               *   O   *
                *     *
                  * *
  ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
  ║   R   ║║   R   ║║   R   ║║   O   ║ = 5 hours   x 3 lamps = 15 hours 
  ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
  ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
  ║   R   ║║   R   ║║   O   ║║   O   ║ = 1 hour    x 2 lamps =  2 hours 
  ╚═══════╝╚═══════╝╚═══════╝╚═══════╝ ----------------------------------
  ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗
  ║Y║║Y║║R║ ║Y║║Y║║R║ ║Y║║O║║O║ ║O║║O║ = 5 minutes x 7 lamps = 35 minutes
  ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝
  ╔═══════╗╔═══════╗╔═══════╗╔═══════╗
  ║   Y   ║║   Y   ║║   O   ║║   O   ║ = 1 minute  x 2 lamps =  2 minutes 
  ╚═══════╝╚═══════╝╚═══════╝╚═══════╝
                                       ------------------------------------------------------------
                                       15 hours + 2 hours + 35 minutes + 2 minutes = 17:37 = 5:37pm
  ```
  Y = Yellow
  R = Red
  O = Off