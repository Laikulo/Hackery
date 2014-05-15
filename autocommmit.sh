while true
do
	sleep  15m
	git add .
	git commit -m "Auto Commit! `date`"
	git push
done
