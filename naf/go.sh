# !/bin/bash
WEBINFDIR=/opt/resin/webapps/naf/WEB-INF
echo "$WEBINFDIR/work"
mv -f "$WEBINFDIR/work" "$WEBINFDIR/workbackup"
mv -f "$WEBINFDIR/web.xml" "$WEBINFDIR/local-web.xml"
cp -f "$WEBINFDIR/gae-web.xml" "$WEBINFDIR/web.xml"
appcfg.sh update .
cp -f "$WEBINFDIR/local-web.xml" "$WEBINFDIR/web.xml"
mv -f "$WEBINFDIR/workbackup" "$WEBINFDIR/work"




