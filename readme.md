# Simple distributed tracing demo
POC

## How to run
Just run `make start` so the dockers get all ready and up then `mvn clean install`.

To run the services:
- `cd catalog-web && mvn spring-boot:run`
- `cd customer-web && mvn spring-boot:run`
- `cd order-web && mvn spring-boot:run`

## Request

### Create order
I was really lazy, gonna leave here the curl command

```bash
curl -X POST \
  http://localhost:8083/order \
  -H 'Accept: */*' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8083' \
  -H 'Postman-Token: f67e889b-88ba-4b26-8758-9ca555882991,08aded89-0ef4-4160-8555-502b94440971' \
  -H 'User-Agent: PostmanRuntime/7.13.0' \
  -H 'X-Organization-Slug: okano' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: 207' \
  -d '{
	"customerId": "ebe1eb26-293b-4c5e-a2c2-156cf2c244f5",
	"items": {
		"4fa499e9-3b53-447d-860a-65482fa44eb2": 2,
		"67b83c39-6bef-470a-aefc-9c0e742c6cf1": 1,
		"104085e6-00d3-4b42-bdac-285ce26c0569": 4
	}
}'
```
