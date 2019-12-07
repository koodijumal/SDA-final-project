function initMap() {
    // The location of out hotel
    var hotel = {lat: 59.397395, lng: 27.758090};

    var map = new google.maps.Map(
        document.getElementById('map'), {zoom: 15, center: hotel});
    // The marker, positioned at hotel
    var marker = new google.maps.Marker({position: hotel, map: map});
}
