import requests

payload = {'key': 'value'}

response = requests.post(
    url='https://httpbin.org/post', json=payload
)
print(response.status_code)
print(response.json())