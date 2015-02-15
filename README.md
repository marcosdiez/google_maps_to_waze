

This open source software solves a limitation in the Waze GPS app by allowing it to open (most) Google Maps URL.

I wrote it because was annoyed with the bug they did not fix this bug in almost a year.
So I solved the problem myself.

What it does is convert google maps URLs like:

http://maps.google.com/maps?q=-23.561522,-46.656101

to waze URLs like

waze://?ll=-23.561522,-46.656101&navigate=yes

I parsed the the AndroidManifest from Google Maps to make sure I can accept everything google maps accepts.

Special thanks for Nobel for having this app's idea.


Interesting Links:

my request for them to fiz this:
https://www.waze.com/forum/viewtopic.php?f=3&t=17684&sid=8c1c030093213ad768d87fd4ee48ab33

source code of this app:

https://github.com/marcosdiez/google_maps_to_waze


