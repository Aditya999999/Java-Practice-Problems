const express = require('express');
const axios = require('axios');
const cors = require('cors');
const app = express();

app.use(cors());

app.get('/linkedin/profile', async (req, res) => {
  try {
    const { accessToken } = req.query;

    // Make a request to the LinkedIn API using the provided access token
    const response = await axios.get(
      `https://api.linkedin.com/v2/me?projection=(id,localizedFirstName,localizedLastName,emailAddress)`,
      {
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
          'X-Restli-Protocol-Version': '2.0.0',
        },
      }
    );

    res.json(response.data);
  } catch (error) {
    console.error('Error fetching LinkedIn profile:', error.message);
    res.status(500).json({ error: 'Failed to fetch LinkedIn profile' });
  }
});

app.listen(3001, () => {
  console.log('Proxy server listening on port 3001');
});
