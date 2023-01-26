function fetchWeather() {
    let input = document.getElementById("input").value;
    fetch(
        `https://api.openweathermap.org/data/2.5/weather?q=${input}&appid=0466cbde7c464dd7f56717dc5a926737&units=metric`
    )
        .then(response => response.json())
        .then(data => {
            console.log(data);

            document.getElementById("temp-text").innerHTML = `Temmperature:`;
            document.getElementById("temp").innerHTML = ` ${data.main.temp} °C`;

            document.getElementById("feels_like-text").innerHTML = `Feels like: `;
            document.getElementById("feels_like").innerHTML = ` ${data.main.feels_like} °C`;

            document.getElementById("temp_min-text").innerHTML = `Low: `;
            document.getElementById("temp_min").innerHTML = ` ${data.main.temp_min} °C`;

            document.getElementById("temp_max-text").innerHTML = `High: `;
            document.getElementById("temp_max").innerHTML = ` ${data.main.temp_max} °C`;

            document.getElementById("description-text").innerHTML = `Description `;
            document.getElementById("description").innerHTML = ` ${data.weather[0].description}`;
        })
        .catch(error => {
            console.log(error);
        });
}
