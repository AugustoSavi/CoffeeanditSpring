# Coffeeandit Spring

## Comandos

### O payload para envio dos dados no BFF é :

```json
{

  "beneficiario": {
    "agencia": "1210",
    "codigoBanco": 341,
    "conta": "101214",
    "cpf": 12735354,
    "nomeFavorecido": "JOSÉ DOS SANTOS"
  },
  "tipoTransacao": "PAGAMENTO_TRIBUTOS",
  "valor": 140
}
```

### Então para contexto não autenticado usar http na porta 8080

```bash
curl -k -v --location --request POST 'http://localhost:8080/transaction' \
--header 'Content-Type: application/json' \
--data-raw '{
    "beneficiario": {
    "agencia": "1210",
    "codigoBanco": 341,
    "conta": "101214",
    "cpf": 12735354,
    "nomeFavorecido": "JOSÉ DOS SANTOS"
    },
    "tipoTransacao": "PAGAMENTO_TRIBUTOS",
    "valor": 50
}'
```

### Para gerar um Token no Keycloak o comando curl é:

```bash
curl --location --request POST 'https://keycloak.coffeeandit.com.br/auth/realms/master/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'password=n_BQ6KgdGb4~MFwJ' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'client_id=coffeeandit' \
--data-urlencode 'scope=openid' \
--data-urlencode 'username=coffeeandit'
```

### Exemplo de Resposta, usar o conteúdo access_token

```json
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzLWtDQlRpcTI1b0hkYW1NS1kxT1YwZ1RpOWRGMTg2ZDFvakljcW1rTWVNIn0.eyJleHAiOjE1ODg1NzkwMzEsImlhdCI6MTU4ODU3NzIzMSwianRpIjoiZmRjYjdhOWUtYzJkNy00YTA3LWJkNzMtMWE0NTFhMzYwNDA3IiwiaXNzIjoiaHR0cDovLzM0LjcxLjczLjEyMjo4MDgwL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI1YTVlMDUwZS04ZGY1LTRmNTktYjE1ZC05MTk5MmQ3MDVmODUiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjb2ZmZWVhbmRpdCIsInNlc3Npb25fc3RhdGUiOiIzMDJkMjlmZS05YjNkLTQzOTktOTEwMS1kMWNkNGY1YmU5N2EiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBDb2ZmZWVBbmRJVFJvbGUgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiY29mZmVlYW5kaXQiLCJlbWFpbCI6ImNvZmZlZWFuZGl0QGNvZmZlZWFuZGl0LmNvbS5iciJ9.Dqoo3VP9BRMt7mszpqETtcumlUhG1O-vljnMpOSn4XJQVXPpP85kLleE5ppsgaFsIq4hWvHGU-hiSWYmKBXthGT1EsAi2l8AyoRgYTML0deo_KMElhl8SaQb7iFJbK3aAN1PJGShM0jTMSKeTKtoyUw4IQPfXk4rdvDlxIHgbSd7LdSSb_HEMEcJsOo0R-myd3W9uIK9DUCrrtKmJ9AOTb2LQgKlhiwzML678_W6CdI_aVpZ22FUfcv29gmGGvr8CMHVf0Uvxovpou0s6TaP6_tu7VqkswJaeqM4_SFi3KeEfGhaPmcV3ivcCdr1VWBIugWx9KDAT-P9VZ1-z6F5Ow",
    "expires_in": 1800,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIxMjlmNDBkYy03OWNhLTQ4MTAtOWZmMi0xMGY1OGY3MjRmODMifQ.eyJleHAiOjE1ODg1NzkwMzEsImlhdCI6MTU4ODU3NzIzMSwianRpIjoiNjY1ZDdjYjMtM2ExYi00ZGZjLTkwZjItZDJkZWY2YzZjNzk1IiwiaXNzIjoiaHR0cDovLzM0LjcxLjczLjEyMjo4MDgwL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6Imh0dHA6Ly8zNC43MS43My4xMjI6ODA4MC9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJzdWIiOiI1YTVlMDUwZS04ZGY1LTRmNTktYjE1ZC05MTk5MmQ3MDVmODUiLCJ0eXAiOiJSZWZyZXNoIiwiYXpwIjoiY29mZmVlYW5kaXQiLCJzZXNzaW9uX3N0YXRlIjoiMzAyZDI5ZmUtOWIzZC00Mzk5LTkxMDEtZDFjZDRmNWJlOTdhIiwic2NvcGUiOiJvcGVuaWQgQ29mZmVlQW5kSVRSb2xlIHByb2ZpbGUgZW1haWwifQ.c9d0Bt2-wuwZ5f0u8ZKze6WWaxV1hdB_n5odBF3CjTw",
    "token_type": "bearer",
    "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzLWtDQlRpcTI1b0hkYW1NS1kxT1YwZ1RpOWRGMTg2ZDFvakljcW1rTWVNIn0.eyJleHAiOjE1ODg1NzkwMzEsImlhdCI6MTU4ODU3NzIzMSwiYXV0aF90aW1lIjowLCJqdGkiOiI4NjA5ZTQxMy1kMGI4LTRiZmMtOGFhYy1jNTEwYmZlNDJkZjQiLCJpc3MiOiJodHRwOi8vMzQuNzEuNzMuMTIyOjgwODAvYXV0aC9yZWFsbXMvbWFzdGVyIiwiYXVkIjoiY29mZmVlYW5kaXQiLCJzdWIiOiI1YTVlMDUwZS04ZGY1LTRmNTktYjE1ZC05MTk5MmQ3MDVmODUiLCJ0eXAiOiJJRCIsImF6cCI6ImNvZmZlZWFuZGl0Iiwic2Vzc2lvbl9zdGF0ZSI6IjMwMmQyOWZlLTliM2QtNDM5OS05MTAxLWQxY2Q0ZjViZTk3YSIsImFjciI6IjEiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImNvZmZlZWFuZGl0IiwiZW1haWwiOiJjb2ZmZWVhbmRpdEBjb2ZmZWVhbmRpdC5jb20uYnIifQ.mRRAES6mTNEF8lfmn68IvVPesR3N8cQciBsEfbGHgaNW6XgFH2HtvY-M7bpT8Ak5RojPHrRd-86rBTF37f7MSBP47ahZxTxqyQgpuNKVrf2UYCIOfEaSB84_Lre8_WZTtH-DIub0GLTK_ieP1l_iUklAwm4MSpVS3hSSCv75V39RNYPibsFqSFoPUxwQT59OBiWZ4W5ooS3APlE37xEU-4tyOI78L7R1oDwVw44SylSen4_VxXGBaYVwZiT_-PCbGpu0JfVq5p_OUooGJFOmsaXAnt_asU8BGbNlCPbvgXiJR7pQsvon6ozfvYM-54AtH8lllnUjSVgCoYENC48fuA",
    "not-before-policy": 1587987476,
    "session_state": "302d29fe-9b3d-4399-9101-d1cd4f5be97a",
    "scope": "openid CoffeeAndITRole profile email"
}
```

### Chamar a aplicação com HTTP na porta 8443 e passando o conteúdo do access_token no Header de Authorization

```bash
    curl -k -v --location --request POST 'https://localhost:8443/transaction' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJDbU9rcWFsd1Q3SnJjVTA5X2ljVkpaQmxOQVpxc3lYUmh4cGFmanAyS3hJIn0.eyJleHAiOjE2NDgwMzY1NzIsImlhdCI6MTY0ODAzNDc3MiwianRpIjoiNTBmM2FmYWQtYTY1YS00YWQxLWE1MzktZTYxNTNiMDc5MTQ3IiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5jb2ZmZWVhbmRpdC5jb20uYnIvYXV0aC9yZWFsbXMvbWFzdGVyIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjE5YjFmMmQzLWViNWMtNGEzOC1hODFhLWE2NGY5YTk5OGQ2NSIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNvZmZlZWFuZGl0Iiwic2Vzc2lvbl9zdGF0ZSI6IjhlZjJlMDBhLTQyY2MtNGM1My1hMTVkLWEwNDk2OWVjMjJjYiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJjb2ZmZWVhbmRpdC10cmFuc2FjdGlvbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBDb2ZmZWVBbmRJVFJvbGUgY29mZmVlYW5kaXQgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImNvbnRhIjoiNzg1OTIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJjb2ZmZWVhbmRpdCIsImFnZW5jaWEiOiIyMDkiLCJlbWFpbCI6ImNvZmZlZWFuZGl0QGNvZmZlZWFuZGl0LmNvbS5iciJ9.EqVTmjtmpn4LcSJ53UUosshFDxMGU9j6Dmzglm31_ZC716Wa9gatOMTKDjfor_GqO2aQlsAWchczkPuXAcTfMZFXAa6B299h4I9jHLvX4SVuMBsPUcEBz0BdIS-xiQghocHzPT4gbXcapkzj7aFviISkjTenI3-MvDTbk0AvImdZ2MoMzufWGmQ_CT3N3cgLPIcjG2AL6nf2L9hLJbc3e09zBD9uo4lPPQmQrrF_S-ua0JempzPn_zAeRiMcsvN7O3j1gxXRgA1lmlQSlQN0bFIc3UeyDbUla-QUXpjFvDnZb6ZzmXtNZUSEGpHTW67a5K-Wf0ljy15T1CcY-HKNWg' \
    --data-raw '{
        "beneficiario": {
        "agencia": "1210",
        "codigoBanco": 341,
        "conta": "101214",
        "cpf": 12735354,
        "nomeFavorecido": "JOSÉ DOS SANTOS"
        },
        "tipoTransacao": "PAGAMENTO_TRIBUTOS",
        "valor": 50
    }'
```