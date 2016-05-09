# !/bin/bash
WEBINFDIR=/opt/resin/webapps/naf/WEB-INF
echo "$WEBINFDIR/work"
mv -rf "$WEBINFDIR/work" "$WEBINFDIR/workbackup"
mv "$WEBINFDIR/web.xml" "$WEBINFDIR/local-web.xml"
mv "$WEBINFDIR/gae-web.xml" "$WEBINFDIR/web.xml"
appcfg.sh update .
mv -f "$WEBINFDIR/local-web.xml" "$WEBINFDIR/web.xml"
mv -f "$WEBINFDIR/workbackup" "$WEBINFDIR/work"




