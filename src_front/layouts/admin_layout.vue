<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
      clipped
    >
      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.text"
          @click="getTest()"
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ item.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item
          class="mt-4"
          @click="getTest()"
        >
          <v-list-item-action>
            <v-icon color="grey darken-1">mdi-plus-circle-outline</v-icon>
          </v-list-item-action>
          <v-list-item-title class="grey--text text--darken-1">Browse Channels</v-list-item-title>
        </v-list-item>
        <v-list-item @click="getTest()">
          <v-list-item-action>
            <v-icon color="grey darken-1">mdi-settings</v-icon>
          </v-list-item-action>
          <v-list-item-title class="grey--text text--darken-1">Manage Subscriptions</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar
      app
      clipped-left
      color="red"
      dense
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"/>
      <v-icon class="mx-4">fab fa-youtube</v-icon>
      <v-toolbar-title class="mr-12 align-center">
        <span class="title">Youtube</span>
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
export default {
  data: () => ({
    drawer: null,
    items: [
      { icon: 'trending_up', text: 'Most Popular' },
      { icon: 'subscriptions', text: 'Subscriptions' },
      { icon: 'history', text: 'History' },
      { icon: 'featured_play_list', text: 'Playlists' },
      { icon: 'watch_later', text: 'Watch Later' }
    ],
    items2: [
      { picture: 28, text: 'Joseph' },
      { picture: 38, text: 'Apple' },
      { picture: 48, text: 'Xbox Ahoy' },
      { picture: 58, text: 'Nokia' },
      { picture: 78, text: 'MKBHD' }
    ]
  }),
  created() {
    this.$vuetify.theme.dark = true
  },
  methods: {
    getTest() {}
  }
}
</script>

<style>
</style>
