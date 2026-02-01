import express from 'express';
import request from 'request-promise-native';

const app = express();
const port = 3001;

// Enable CORS
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
  next();
});

app.get('/linkedin/profile', async (req, res) => {
  try {
    const { authorization } = req.headers;
    if (!authorization) {
      res.status(401).json({ error: 'Unauthorized' });
      return;
    }

    const accessToken = authorization.split(' ')[1];
    if (!accessToken) {
      res.status(401).json({ error: 'Unauthorized' });
      return;
    }

    const profile = await request({
      url: 'https://api.linkedin.com/v2/me',
      headers: {
        'Authorization': `Bearer ${accessToken}`,
        'Connection': 'Keep-Alive',
        'x-li-format': 'json',
      },
      json: true,
    });

    res.json(profile);
  } catch (error) {
    console.error('Error fetching LinkedIn profile:', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.listen(port, () => {
  console.log(`Proxy server listening on port ${port}`);
});
