This open source software solves a limitation in the Waze GPS app by allowing it to open (hopefully) any Google Maps URLs.

I did a bug report last year and they still did not fix it themselves, so I solved on my own.

What it does is convert google maps URLs like:

http://maps.google.com/maps?q=-23.561522,-46.656101

to waze URLs like

waze://?ll=-23.561522,-46.656101&navigate=yes

I parsed the AndroidManifest from Google Maps to make sure my app accepts the same URLs.

Special thanks for Nobel for having this app's idea.


Interesting Links:

My request for Waze Team to fix the issue:
https://www.waze.com/forum/viewtopic.php?f=3&t=17684&sid=8c1c030093213ad768d87fd4ee48ab33

Source code of this app:

https://github.com/marcosdiez/google_maps_to_waze


I am not affiliated with any third party company. Use this app at your own responsibility.
