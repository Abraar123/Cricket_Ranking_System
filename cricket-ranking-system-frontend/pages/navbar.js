fetch('navbar.html')
  .then(function (res) { return res.text(); })
  .then(function (html) {
    document.getElementById('navbar-container').innerHTML = html;

    var current = window.location.pathname.split('/').pop();
    document.querySelectorAll('.nav-link').forEach(function (link) {
      if (link.getAttribute('href') === current) {
        link.classList.add('active');
      }
    });
  });