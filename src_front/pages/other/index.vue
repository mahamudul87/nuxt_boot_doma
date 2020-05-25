<template>
  <video-player 
    :options="playerOptions" 
    class="vjs-custom-skin" 
    @ready="playerReadied"/>
</template>

<script>
import { videoPlayer } from 'vue-video-player'
import videojs from 'video.js'
window.videojs = videojs
// hls plugin for videojs6
require('videojs-contrib-hls/dist/videojs-contrib-hls.js')
export default {
  components: {
    videoPlayer
  },
  data() {
    return {
      playerOptions: {
        // videojs and plugin options
        height: '360',
        sources: [
          {
            withCredentials: false,
            type: 'application/x-mpegURL',
            src:
              'https://5b44cf20b0388.streamlock.net:8443/live/ngrp:live_all/playlist.m3u8'
          }
        ],
        controlBar: {
          timeDivider: false,
          durationDisplay: false
        },
        flash: { hls: { withCredentials: false } },
        html5: { hls: { withCredentials: false } },
        poster:
          'https://surmon-china.github.io/vue-quill-editor/static/images/surmon-5.jpg'
      }
    }
  },
  methods: {
    playerReadied(player) {
      var hls = player.tech({ IWillNotUseThisInPlugins: true }).hls
      player.tech_.hls.xhr.beforeRequest = function(options) {
        // console.log(options)
        return options
      }
    }
  }
}
</script>
