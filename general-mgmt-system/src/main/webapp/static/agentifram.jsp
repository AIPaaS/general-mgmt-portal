<!DOCTYPE html>
<html>
  <head>
    <meta charset='utf-8' />
    <title>agentiframe</title>
  </head>
  <body>
    <script type="text/javascript">
        window.onload = function() {

            var isSet = false;
            var inteval = setInterval(function() {
                var search = location.search.replace('?', '');
                if (isSet) {
                    clearInterval(inteval);
                    return  ;
                }
                if (search) {
                    var height = search.split('=')[1];
                    var doc = parent.parent.document;
                    var ifr = doc.getElementById('mainFrame');
                    ifr.style.height = height + 'px';
                    isSet = true;
                }
            }, 500);
        }
    </script>
  </body>
</html>