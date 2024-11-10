/**
 * 
 */
// Search job functionality
function searchJobs() {
  let searchQuery = document.getElementById('search').value.toLowerCase();
  alert("You searched for: " + searchQuery);
}

// Form Validation for Login
function validateLogin() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  if (!username || !password) {
    alert("Please fill in all fields.");
    return false;
  }

  return true;
}

// Form Validation for Registration
function validateRegister() {
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('regPassword').value;

  if (!name || !email || !password) {
    alert("Please fill in all fields.");
    return false;
  }

  return true;
}
document.getElementById('color-mode-toggle').addEventListener('click', function() {
  document.body.classList.toggle('dark-mode');
  document.querySelector('header').classList.toggle('dark-mode');
  document.querySelector('footer').classList.toggle('dark-mode');
  document.querySelector('.hero').classList.toggle('dark-mode');
  document.querySelector('.job-listings').classList.toggle('dark-mode');
  document.querySelectorAll('.job-card').forEach(card => {
    card.classList.toggle('dark-mode');
  });
  
  // Toggle button text
  if (document.body.classList.contains('dark-mode')) {
    this.textContent = 'Switch to Light Mode';
  } else {
    this.textContent = 'Switch to Dark Mode';
  }
});
