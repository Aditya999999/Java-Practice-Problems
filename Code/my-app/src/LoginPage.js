import React from 'react';

const LoginPage = () => {
  const handleLinkedInLogin = () => {
    const clientId = '77d13jh5vfo0my';
    const redirectUri = 'https%3A%2F%2Fmy-app.com';

    window.location.href = `https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}&state=987654321&scope=r_liteprofile r_emailaddress`;

    
  };

  return (
    <div>
      <h1>Login Page</h1>
      <button onClick={handleLinkedInLogin}>Login with LinkedIn</button>
    </div>
  );
};

export default LoginPage;


// import { LinkedIn } from 'react-linkedin-login-oauth2';
// import { useState } from 'react';
// import { useNavigate } from 'react-router-dom';

// const LoginPage= () =>{
//   const [isLoggedIn, setIsLoggedIn] = useState(false);
//   const navigate = useNavigate();

//   const handleLinkedInLoginSuccess = data => {
//     // You can perform additional logic here, such as sending the authorization code to your server for verification

//     // Update isLoggedIn state to true
//     setIsLoggedIn(true);

//     // Redirect to the dashboard page
//     navigate('/dashboard');
//   };

//   const handleLinkedInLoginFailure = error => {
//     // Handle login failure or error here
//     console.log(error);
//   };

//   // If the user is already logged in, redirect to the dashboard immediately
//   if (isLoggedIn) {
//     navigate('/dashboard');
//   }

//   return (
//     <div>
//       {/* Your login form */}
//       <form>
//         <label htmlFor="email">Email:</label>
//         <input type="email" id="email" />

//         <label htmlFor="password">Password:</label>
//         <input type="password" id="password" />

//         <button>Login</button>
//       </form>

//       <LinkedIn
//         clientId="77d13jh5vfo0my"
//         onSuccess={handleLinkedInLoginSuccess}
//         onFailure={handleLinkedInLoginFailure}
//         redirectUri="http%3A%2F%2Flocalhost%3A3000" // Adjust the redirect URI as per your setup
//         scope="r_liteprofile"
//       >
//         Login with LinkedIn
//       </LinkedIn>
//     </div>
//   );
// };

// export default LoginPage;

