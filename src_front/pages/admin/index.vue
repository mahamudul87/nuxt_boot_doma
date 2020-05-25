<template>
  <v-content>
    <v-container class="fill-height">
      <v-row
        justify="center"
        align="center"
      >
        <v-row
          justify="center"
          align="center"
        >
        <nuxt-link to="/">TOP</nuxt-link>
        <nuxt-link to="/other">OTHER PAGE</nuxt-link>
          <div>
            <h1 class="title">
              this is admin page
            </h1>
            <h2 class="subtitle">
              Hello {{ name }}.
            </h2>
            <div style="display: inline-flex;">
              <button
                class="button--grey"
                @click="reload"
              >reload
              </button>
              <logout url="/logout"/>
            </div>
          </div>
        </v-row>
    </v-row></v-container>
  </v-content>
</template>

<script>
//i have to use code for checking whether page is authenticated or not
import Logout from '~/components/Logout.vue'

export default {
  layout: 'admin_layout',
  components: {
    Logout
  }
}
</script>

<style>
</style>
