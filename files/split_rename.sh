rm -r shortened
mkdir shortened
var=$( ls pointinfos/flip* )
echo $var
k=1
for j in $var
do
split -b 8000 $j pointinfos/splitted
    for i in $( ls pointinfos/splitted* )
    do
    mv -f $i shortened/trip_$k.txt
    ((k++))
    done
done
