# UploadController

UploadController


---
## uploadImage

> BASIC

**Path:** /upload/uploadImage

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | multipart/form-data | YES |  |

**Form:**

| name | value | required | type | desc |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| file |  | YES | file |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| oldName | string |  |
| newName | string |  |
| path | string |  |

**Response Demo:**

```json
{
  "oldName": "",
  "newName": "",
  "path": ""
}
```




---
## delFile

> BASIC

**Path:** /upload/delFile

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| fileName |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean |  |

**Response Demo:**

```json
false
```




---
## downloadFile

> BASIC

**Path:** /upload/downloadFile

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| fileName |  | NO |  |
| downloadPath |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean |  |

**Response Demo:**

```json
false
```



