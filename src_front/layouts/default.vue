<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-left
      color="red"
      dense
    >
      <v-icon class="mx-4">fab fa-youtube</v-icon>
      <v-toolbar-title class="mr-12 align-center">
        <span class="title">VMotion</span>
      </v-toolbar-title>
      <v-spacer/>
      <v-row
        align="center"
        style="max-width: 650px"
      >
        <v-text-field
          :append-icon-cb="() => {}"
          placeholder="Search..."
          single-line
          append-icon="search"
          color="white"
          hide-details
        />
      </v-row>
    </v-app-bar>
    <nuxt/>
  </v-app>
</template>
<script>
export default {}
</script>

<style>
</style>
