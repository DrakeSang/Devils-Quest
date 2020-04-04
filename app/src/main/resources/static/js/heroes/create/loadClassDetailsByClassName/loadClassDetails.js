function loadClassDetails(className) {
    let url = "/api/classes/get-class-details/" + className;

    fetch(url, {method: 'get'})
        .then(response => response.json())
        .then(heroClass => {
            $('.hero-image-container img').attr("src", heroClass.imageUrl);

            $('.hero-overview textarea').html(heroClass.overview);
    })
}

export { loadClassDetails };