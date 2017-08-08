# All In Interfaces

## Authorization

### Login
- [get] /auth/login.jsp show login page
- [post] /auth/login.jsp submit login request
- [get] /auth/index.do show dashboard

### Role
- [GET] /auth/role.do select by pagination
- [POST] /auth/role/do add a role
- [DELETE] /auth/role/{id}.do delete by id
- [PUT] /auth/role/{id}.do update by id
- [POST] /auth/role/permission.do associate with a permission
- [DELETE] /auth/role/permission/{ids}.do disconnect associations of permissions
- [UPDATE] /auth/role/permission/{ids}.do update associations of permissions

### Permission
- [GET] /auth/permission.do select by pagination
- [POST] /auth/permission/do add a role
- [DELETE] /auth/permission/{id}.do delete by id
- [PUT] /auth/permission/{id}.do update by id

### User
- [GET] /auth/user.do select by pagination
- [POST] /auth/user/do add a user
- [DELETE] /auth/user/{id}.do delete by id
- [PUT] /auth/user/{id}.do update by id