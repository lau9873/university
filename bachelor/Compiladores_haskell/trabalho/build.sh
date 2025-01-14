#!/bin/bash

alex Lexer.x
happy --ghc Parser.y
ghc Main.hs
./Main
