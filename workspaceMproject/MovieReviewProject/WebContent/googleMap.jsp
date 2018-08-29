<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<style>
#map {
	border-radius: 50px;
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#pac-input {
	background-color: #fff;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	vertical-align: bottom;
	margin-left: 12px;
	padding: 0 11px 0 13px;
	text-overflow: ellipsis;
	width: 400px;
}
</style>
<meta charset="UTF-8">
<title>너의 영화는</title>

</head>
<body>
	<div class="pac-card" id="pac-card">
		<div id="pac-container">
			<input id="pac-input" type="text">
		</div>
	</div>
	<div id="map"></div>
	<div id="infowindow-content"></div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDPzl09wPmTlQbQ6qkFf70tQoru1BB42f0&libraries=places&callback=initMap"
		async defer></script>
	<script>
		// This example requires the Places library. Include the libraries=places
		// parameter when you first load the API. For example:
		// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">
		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 35.865472,
					lng : 128.593363
				},
				zoom : 13
			});

			function getLocation() {
				if (navigator.geolocation) { // GPS를 지원하면
					navigator.geolocation.getCurrentPosition(
							function(position) {
								var darwin = new google.maps.LatLng(
										position.coords.latitude,
										position.coords.longitude);
								map.setCenter(darwin);
							}, function(error) {
								console.error(error);
							}, {
								enableHighAccuracy : false,
								maximumAge : 0,
								timeout : Infinity
							});
				} else {
					alert('GPS를 지원하지 않습니다');
				}
			}
			getLocation();
			var card = document.getElementById('pac-card');
			var input = document.getElementById('pac-input');
			var types = document.getElementById('type-selector');
			var strictBounds = document
					.getElementById('strict-bounds-selector');

			map.controls[google.maps.ControlPosition.TOP_RIGHT].push(card);

			var autocomplete = new google.maps.places.Autocomplete(input);

			// Bind the map's bounds (viewport) property to the autocomplete object,
			// so that the autocomplete requests use the current map bounds for the
			// bounds option in the request.
			autocomplete.bindTo('bounds', map);

			// Set the data fields to return when the user selects a place.
			autocomplete.setFields([ 'address_components', 'geometry', 'icon',
					'name' ]);

			var infowindow = new google.maps.InfoWindow();
			var infowindowContent = document
					.getElementById('infowindow-content');
			infowindow.setContent(infowindowContent);
			var marker = new google.maps.Marker({
				map : map,
				anchorPoint : new google.maps.Point(0, -29)
			});

			autocomplete
					.addListener(
							'place_changed',
							function() {
								infowindow.close();
								marker.setVisible(false);
								var place = autocomplete.getPlace();
								if (!place.geometry) {
									// User entered the name of a Place that was not suggested and
									// pressed the Enter key, or the Place Details request failed.
									window
											.alert("No details available for input: '"
													+ place.name + "'");
									return;
								}

								// If the place has a geometry, then present it on a map.
								if (place.geometry.viewport) {
									map.fitBounds(place.geometry.viewport);
								} else {
									map.setCenter(place.geometry.location);
									map.setZoom(17); // Why 17? Because it looks good.
								}
								marker.setPosition(place.geometry.location);
								marker.setVisible(true);

								var address = '';
								if (place.address_components) {
									address = [
											(place.address_components[0]
													&& place.address_components[0].short_name || ''),
											(place.address_components[1]
													&& place.address_components[1].short_name || ''),
											(place.address_components[2]
													&& place.address_components[2].short_name || '') ]
											.join(' ');
								}

								infowindowContent.children['place-icon'].src = place.icon;
								infowindowContent.children['place-name'].textContent = place.name;
								infowindowContent.children['place-address'].textContent = address;
								infowindow.open(map, marker);
							});

			// Sets a listener on a radio button to change the filter type on Places
			// Autocomplete.
			function setupClickListener(id, types) {
				var radioButton = document.getElementById(id);
				radioButton.addEventListener('click', function() {
					autocomplete.setTypes(types);
				});
			}

			setupClickListener('changetype-all', []);

			document.getElementById('use-strict-bounds').addEventListener(
					'click',
					function() {
						console.log('Checkbox clicked! New state='
								+ this.checked);
						autocomplete.setOptions({
							strictBounds : this.checked
						});
					});
		}
	</script>

</body>
</html>