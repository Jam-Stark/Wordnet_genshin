// JavaScript source code
function register() {
	var register = document.getElementById('register');
	var register1 = document.getElementById('register1');
	if (register.style.display == 'block') {
		register.style.display = 'none';
		register1.style.display = 'none';
	} else {
		register.style.display = 'block';
		register1.style.display = 'none';
	}
}

function register1() {
	var register = document.getElementById('register');
	var register1 = document.getElementById('register1');
	if (register1.style.display == 'block') {
		register1.style.display = 'none';
		register.style.display = 'none';
	} else {
		register1.style.display = 'block';
		register.style.display = 'none';
	}
}
