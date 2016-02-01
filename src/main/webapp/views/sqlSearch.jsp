<!DOCTYPE HTML>
<html>
<head>
<title>Google Maps AJAX + mySQL/PHP Example</title>
</head>

<body>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDq5GAE3tOpXqt2ig9jXSYOh5PUx1tPTCU"
		type="text/javascript"></script>
	<div align="CENTER">
		<input type="text" id="addressInput" size="30" /> 
		<input type="text" id="radiusSelect" size="10"/> 
		<input type="button" onclick="searchLocations()" value="Search" />
	</div>
	<div align="CENTER">
		<select id="locationSelect" style="width: 500px; visibility: hidden"></select>
	</div>
	<div align="CENTER" id="map" style="width: 500px; height: 200px"></div>

	<script>
		var map;
		var markers = [];
		var infoWindow;
		var locationSelect;
		function load() {
			map = new google.maps.Map(document.getElementById("map"), {
				center : new google.maps.LatLng(40, -100),
				zoom : 4,
				mapTypeId : 'roadmap',
				mapTypeControlOptions : {
					style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
				}
			});
			infoWindow = new google.maps.InfoWindow();

			locationSelect = document.getElementById("locationSelect");
			locationSelect.onchange = function() {
				var markerNum = locationSelect.options[locationSelect.selectedIndex].value;
				if (markerNum != "none") {
					google.maps.event.trigger(markers[markerNum], 'click');
				}
			};
		}

		function searchLocations() {
			var address = document.getElementById("addressInput").value;
			var geocoder = new google.maps.Geocoder();
			geocoder.geocode({
				address : address
			}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					searchLocationsNear(results[0].geometry.location);
				} else {
					alert(address + ' not found');
				}
			});
		}

		function clearLocations() {
			infoWindow.close();
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers.length = 0;

			locationSelect.innerHTML = "";
			var option = document.createElement("option");
			option.value = "none";
			option.innerHTML = "See all results:";
			locationSelect.appendChild(option);
		}

		function searchLocationsNear(center) {
			clearLocations();

			var radius = document.getElementById('radiusSelect').value;
			/*  var searchUrl = 'phpsqlsearch_genxml.php?lat=' + center.lat() + '&lng=' + center.lng() + '&radius=' + radius;  */
			var searchUrl = "${pageContext.request.contextPath}"+'/GoogleQuerySearch?lat='+ center.lat() + '&lng=' + center.lng() + '&radius=' + radius;
			console.log(searchUrl);
			downloadUrl(
					searchUrl,
					function(data) {
						var xml = parseXml(data);
						var markerNodes = xml.documentElement
								.getElementsByTagName("marker");
						var bounds = new google.maps.LatLngBounds();
						for (var i = 0; i < markerNodes.length; i++) {
							var name = markerNodes[i].getAttribute("name");
							var address = markerNodes[i]
									.getAttribute("address");
							var distance = parseFloat(markerNodes[i]
									.getAttribute("distance"));
							var latlng = new google.maps.LatLng(
									parseFloat(markerNodes[i]
											.getAttribute("lat")),
									parseFloat(markerNodes[i]
											.getAttribute("lng")));

							createOption(name, distance, i);
							createMarker(latlng, name, address, parseFloat(markerNodes[i].getAttribute("lat")),parseFloat(markerNodes[i].getAttribute("lng")) );
							bounds.extend(latlng);
						}
						map.fitBounds(bounds);
						locationSelect.style.visibility = "visible";
						locationSelect.onchange = function() {
							var markerNum = locationSelect.options[locationSelect.selectedIndex].value;
							google.maps.event.trigger(markers[markerNum],
									'click');
						};
					});
		}

		function createMarker(latlng, name, address, lat, lng) {
			var html = "<b>" + name + "</b> <br/>" + address;
			var marker = new google.maps.Marker({
				map : map,
				position : latlng,
				url: "${pageContext.request.contextPath}"+'/CaterInfo?id=' + name + '&lat=' + lat + '&lng=' + lng
			});
			google.maps.event.addListener(marker, 'click', function() {
				infoWindow.setContent(html);
				window.location.href = marker.url;
				infoWindow.open(map, marker);
			});
			markers.push(marker);
		}

		function createOption(name, distance, num) {
			var option = document.createElement("option");
			option.value = num;
			option.innerHTML = name + "(" + distance.toFixed(1) + ")";
			locationSelect.appendChild(option);
		}

		function downloadUrl(url, callback) {
			var request = window.ActiveXObject ? new ActiveXObject(
					'Microsoft.XMLHTTP') : new XMLHttpRequest;

			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					request.onreadystatechange = doNothing;
					callback(request.responseText, request.status);
				}
			};
			request.open('GET', url, true);
			request.send(null);
		}

		function parseXml(str) {
			if (window.ActiveXObject) {
				var doc = new ActiveXObject('Microsoft.XMLDOM');
				doc.loadXML(str);
				return doc;
			} else if (window.DOMParser) {
				return (new DOMParser).parseFromString(str, 'text/xml');
			}
		}

		function doNothing() {
		}

		$(document).ready(function(){
			load();
		});
	</script>  
	<script>
		$(document).ready(function(){
			alert("hello");
		});
	</script>
</body>
</html>
