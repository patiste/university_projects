#!/bin/bash

function testWynikow()
{
program=$1
file=$2
./$program < $file.in > $file.out2 2> $file.err2

diff -Bw $file.out2 $file.out > /dev/null

if [[ $? -eq 0 ]]
then
echo -n "WYNIK OK    "
else
echo -n "ZLY WYNIK   "
fi

diff -Bw $file.err2 $file.err > /dev/null

if [[ $? -eq 0 ]]
then
echo -n "ERROR OK    "
else
echo -n "ZLY ERROR   "
fi

#valgrind --leak-check=full ./$program < $file.in > /dev/null 2> /dev/null

#if [[ $? -eq 0 ]]
#then
#echo -n "VALGRIND OK   "
#else
#echo -n "ZLY VALGRIND  "
#fi


echo "$file"
}

prog=$1
for f in $2/*.in
do
testWynikow $prog ${f%.in}
done
