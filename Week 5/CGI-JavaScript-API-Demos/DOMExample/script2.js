function SearchMovie() {
    let moviename = document.getElementById('moviename').value;
    fetch(`http://www.omdbapi.com/?apikey=8266bbff&t=${moviename}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById('poster').src = data.Poster;
            document.getElementById('title').innerHTML = data.Title;
            document.getElementById('plot').innerHTML = data.Plot;
            document.getElementById('genre').innerHTML = data.Genre;
            document.getElementById('actors').innerHTML = data.Actors;
            document.getElementById('language').innerHTML = data.Language;
            document.getElementById('duration').innerHTML = data.Runtime;
        });
}