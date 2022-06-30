export interface UserLoginData {
  firstname: string;
  lastname: string;
  username: string;
  password: string;
  accountNonExpired: boolean;
  accountNonLocked: boolean;
  credentialsNonExpired: boolean;
  enabled: boolean;
  authorities: [{authority: string}]
}
