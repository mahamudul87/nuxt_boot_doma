<template>
  <div>redirecting...</div> <!-- 一瞬表示されてしまうので、何かダミーを表示しておく -->
</template>

<script>
export default {
  layout: 'login_layout',
  beforeCreate() {
    // Redirect to the backend login page the moment it is displayed
    // During production, `/ login` and login page match so this component doesn't work
    window.location = 'http://localhost:8080/login'
  }
}
</script>
