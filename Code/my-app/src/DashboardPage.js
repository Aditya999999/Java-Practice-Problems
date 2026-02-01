// import React, { useEffect, useState } from 'react';

// const DashboardPage = () => {
//   useEffect(() => {
//     fetchAccessToken();
//   }, []);

//   const fetchAccessToken = () => {
//     const data = new URLSearchParams();
//     data.append('grant_type', 'authorization_code');
//     data.append('code', 'AQVTNVO-oFXKYPo6SnSpuRQhx1-Ya3Lcwhruxer3StUBG1esx-yMOnz38cEor2XFTT9tD04xQVKd6o1JqdeAtBnhdx9PqYROWCgEgba7Tni1W0lqdo9bdF20_sGBTLHJtCmOvHxLc0t3OakihLFaf6S6UpBxCVAhi1kNWUyOAGC8tmdTTieOQw3Q6FqAmyFUnIQ_hwfKQipY4d-YZTI4b4NhTDdMBamjIkQsnJU_PB0NpX9b1g6RcZSF0h4PYtaQbSDNePPJKs03HfCglvx1lHmmHUneEPASujLHE8706vhodAhYSW3VQfNl6d9xRxijawAd7F5Q7oaIQT6qigCEjUTejPM9Pg');
//     data.append('redirect_uri', 'https://my-app.com');
//     data.append('client_id', '77d13jh5vfo0my');
//     data.append('client_secret', 'osGhZNIQPFX6Uc9N');
  
//     fetch('https://www.linkedin.com/oauth/v2/accessToken', {
//       method: 'POST',
//       body: data
//     })
//       .then(response => response.json())
//       .then(data => {
//         // Store the access token in a variable
//         const access_token = data.access_token;
//         console.log(access_token);
//       })
//       .catch(error => {
//         // Handle the error
//         console.error(error);
//       });
//   };

//   return (
//     <div>
//       <Main />
//     </div>
//   );
// };

// const Main = () => {
//   const [response, setResponse] = useState('');

//   useEffect(() => {
//     const fetchData = async () => {
//       try {
//         const response = await fetch('https://api.linkedin.com/v2/me', {
//           headers: {
//             Authorization:
//               'Bearer AQXMZF8_uf3oYMWDPN39xZnq3zFtzMnn3wX8fjhVKSSJKtCAAhSe6dRE0cg8T4koMGCkganijhfGobdS0-tdP5nnbPH6G6QtMtEKrn5gXYYX0XEut5fO2cE4MYyQI3iswFPoD7ugkpEOAz9ZrHKPhngLRBQQlKIX2_0f52SgsVUMStCDcrn3696PGFtICsEmllTxFyXoW4U30GBPYm3PPXYZw14O3XKXoPUDdj0PKY1wHZH3nLbtGtuVulJbAm7WijL0NWRHMDBbevtDbYnxh70_GvUVuDX_N7rsC54AXhVAAetcKLeiKUgL7HntQ5X-tQPzTzYFaHDg-TL8Q0L3CljV9mNJXg',
//           },
//         });

//         const data = await response.json();

//         // Set the response in the state
//         setResponse(JSON.stringify(data));
//       } catch (error) {
//         // Handle the error
//         console.error(error);
//       }
//     };

//     fetchData();
//   }, []);

//   return (
//     <div>
//       <pre>{response}</pre>
//     </div>
//   );
// };

// export default DashboardPage;

